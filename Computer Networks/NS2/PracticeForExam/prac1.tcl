
set ns [new Simulator]

#CREATE HANDLE FOR TRACE FILE.

set nf [open out.nam w]
$ns namtrace-all $nf


#CREATE PROCEDURE FINISH.
proc finish {} {
	global ns nf
	$ns flush-trace
	close $nf
	exec nam out.nam &
	exit 0
}




#CREATE NODES
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]

#ESTABLISH LINK.
$ns duplex-link $n0 $n1 1Mb 10ms DropTail
$ns duplex-link $n1 $n2 1Mb 10ms DropTail
$ns duplex-link $n0 $n2 1Mb 10ms DropTail
$ns duplex-link $n2 $n3 1Mb 10ms SFQ

$ns queue-limit $n0 $n1 10
$ns queue-limit $n2 $n1 10
$ns queue-limit $n0 $n2 10
$ns queue-limit $n2 $n3 10


#CREATE UDP AGENTS AND LINK THEM TO NODES.
set udp0 [new Agent/UDP]
set udp1 [new Agent/UDP]
set udp2 [new Agent/UDP]
set udp3 [new Agent/UDP]

$ns attach-agent $n0 $udp0
$ns attach-agent $n1 $udp3
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

set cbr2 [new Application/Traffic/CBR]
$cbr2 set packetSize_ 500
$cbr2 set interval_ 0.005
$cbr2 attach-agent $udp2

set cbr3 [new Application/Traffic/CBR]
$cbr3 set packetSize_ 500
$cbr3 set interval_ 0.005
$cbr3 attach-agent $udp3



#CREATE A TRAFFIC SINK.
set null0 [new Agent/Null]
set null1 [new Agent/Null]
set null2 [new Agent/Null]
set null3 [new Agent/Null]


$ns attach-agent $n0 $null0
$ns attach-agent $n1 $null1
$ns attach-agent $n2 $null2
$ns attach-agent $n3 $null3


#CONNECT 2 AGENTS.

$ns connect $udp0 $null1
$ns connect $udp1 $null2
$ns connect $udp3 $null3
$ns connect $udp2 $null0


$udp0 set class_ 1
$udp1 set class_ 2
$udp2 set class_ 3
$udp3 set class_ 4
$ns color 1 Blue
$ns color 2 Red
$ns color 3 Orange
$ns color 4 Brown

#TELL CBR AGENT WHEN TO START AND STOP SENDING.
$ns at 0.5 "$cbr0 start"
$ns at 0.5 "$cbr1 start"
$ns at 0.5 "$cbr2 start"
$ns at 0.5 "$cbr3 start"



$ns at 1.5 "$cbr0 set rate_ 0.5Mb"
$ns at 2.5 "$cbr0 set rate_ 1.0Mb"
$ns at 2.5 "$cbr0 set rate_ 1.5Mb"
#$ns at 2.5 "$cbr0 set rate_ 4.0Mb"


$ns at 4.5 "$cbr0 stop"
$ns at 4.5 "$cbr1 stop"
$ns at 4.5 "$cbr2 stop"
$ns at 4.5 "$cbr3 stop"







$ns at 5.0 "finish"

$ns run
