set ns [new Simulator]

#CREATE HANDLE FOR TRACE FILE.

set nf [open example1trace.nam w]
$ns namtrace-all $nf


#CREATE PROCEDURE FINISH.
proc finish {} {
	global ns nf
	$ns flush-trace
	close $nf
	exec nam example1trace.nam &
	exit 0
}




#CREATE NODES
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]

#ESTABLISH LINK.
$ns duplex-link $n0 $n1 1Mb 10ms DropTail
$ns duplex-link $n1 $n2 1Mb 10ms DropTail
$ns duplex-link $n0 $n2 1Mb 10ms DropTail


#CREATE UDP AGENTS AND LINK THEM TO NODES.
set udp0 [new Agent/UDP]
$ns attach-agent $n0 $udp0
$ns attach-agent $n1 $udp1
$ns attach-agent $n2 $udp2


#CREATE CBR TRAFFIC SOURCE AND ATTACH IT TO NODES.

set cbr0 [new Application/Traffic/CBR]
$cbr0 set packetSize_ 500
$cbr0 set interval_ 0.005
$cbr0 attach-agent $udp0

#CREATE CBR TRAFFIC SOURCE AND ATTACH IT TO NODES.

set cbr1 [new Application/Traffic/CBR]
$cbr1 set packetSize_ 500
$cbr1 set interval_ 0.005
$cbr1 attach-agent $udp1

#CREATE CBR TRAFFIC SOURCE AND ATTACH IT TO NODES.

set cbr1 [new Application/Traffic/CBR]
$cbr1 set packetSize_ 500
$cbr1 set interval_ 0.005
$cbr1 attach-agent $udp1

#CREATE A TRAFFIC SINK.
set null0 [new Agent/Null]
set null1 [new Agent/Null]
set null2 [new Agent/Null]


$ns attach-agent $n0 $null0
$ns attach-agent $n1 $null1
$ns attach-agent $n2 $null2

#CONNECT 2 AGENTS.

$ns connect $udp0 $null0
$ns connect $udp1 $null1
$ns connect $udp2 $null2


#TELL CBR AGENT WHEN TO START AND STOP SENDING.
$ns at 0.5 "$cbr0 start"
$ns at 0.5 "$cbr1 start"
$ns at 0.5 "$cbr2 start"

$ns at 4.5 "$cbr0 stop"
$ns at 4.5 "$cbr1 stop"
$ns at 4.5 "$cbr2 stop"






$ns at 5.0 "finish"

$ns run
