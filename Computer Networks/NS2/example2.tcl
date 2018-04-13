set ns [new Simulator]

#CREATE HANDLE FOR TRACE FILE.

set nf [open r1.nam w]
$ns namtrace-all $nf


#CREATE PROCEDURE FINISH.
proc finish {} {
	global ns nf
	$ns flush-trace
	close $nf
	exec nam r1.nam &
	exit 0
}




#CREATE NODES
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]

#ESTABLISH LINK.
$ns duplex-link $n0 $n1 1Mb 10ms DropTail
$ns duplex-link $n1 $n2 1Mb 10ms DropTail
$ns duplex-link $n2 $n0 1Mb 10ms DropTail


#Create a UDP agent and attach it to node n0
set udp0 [new Agent/UDP]
$ns attach-agent $n0 $udp0

# Create a CBR traffic source and attach it to udp0
set cbr0 [new Application/Traffic/CBR]
$cbr0 set packetSize_ 500
$cbr0 set interval_ 0.005
$cbr0 attach-agent $udp0

#Create a UDP agent and attach it to node n1
set udp1 [new Agent/UDP]
$ns attach-agent $n1 $udp1

# Create a CBR traffic source and attach it to udp1
set cbr1 [new Application/Traffic/CBR]
$cbr1 set packetSize_ 500
$cbr1 set interval_ 0.005
$cbr1 attach-agent $udp1

#Create a UDP agent and attach it to node n2
set udp2 [new Agent/UDP]
$ns attach-agent $n2 $udp2

# Create a CBR traffic source and attach it to udp2
set cbr2 [new Application/Traffic/CBR]
$cbr2 set packetSize_ 500
$cbr2 set interval_ 0.005
$cbr2 attach-agent $udp2




set null0 [new Agent/Null]

$ns attach-agent $n1 $null0
$ns attach-agent $n2 $null0
$ns attach-agent $n0 $null0



$ns connect $udp0 $null0
$ns connect $udp1 $null0
$ns connect $udp2 $null0


$ns at 0.5 "$cbr0 start"
$ns at 0.5 "$cbr1 start"
$ns at 0.5 "$cbr2 start"
$ns at 4.5 "$cbr0 stop"
$ns at 4.5 "$cbr1 stop"
$ns at 4.5 "$cbr2 stop"

$udp0 set class_ 1
$udp1 set class_ 2
$udp2 set class_ 3

$ns color 1 Blue
$ns color 2 Red
$ns color 3 Green

$ns at 5.0 "finish"

$ns run
