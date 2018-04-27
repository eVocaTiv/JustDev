set ns [new Simulator]

#Define different colors for data flows (for NAM)
$ns color 1 Blue
$ns color 2 Red
$ns color 3 Green

#Open the NAM trace file
set nf [open tracefile.nam w]
$ns namtrace-all $nf
set tr [open TCP.tr w]
$ns trace-all $tr

#Define a 'finish' procedure
proc finish {} {
	global ns nf tr
	$ns flush-trace
	#Close the NAM trace file
	close $nf
	close $tr
	#Execute NAM on the trace file
	exec nam tracefile.nam &
	exit 0
}

#Create six nodes
set n0 [$ns node]
set n1 [$ns node]
set n2 [$ns node]
set n3 [$ns node]
set n4 [$ns node]
set n5 [$ns node]
set n6 [$ns node]
set n7 [$ns node]

###
### ENTER YOUR CODE HERE
###

#CREATE TCP AGENT AT 0 AND 1.

#Create a UDP agent and attach it to node n0
set udp0 [new Agent/TCP]
$ns attach-agent $n0 $udp0
# Create a CBR traffic source and attach it to udp0
set cbr0 [new Application/Traffic/CBR]
$cbr0 set packetSize_ 500
$cbr0 set rate_ 2Mbps
$cbr0 attach-agent $udp0


#Create a UDP agent and attach it to node n0
set udp1 [new Agent/TCP]
$ns attach-agent $n1 $udp1
# Create a CBR traffic source and attach it to udp0
set cbr1 [new Application/Traffic/CBR]
$cbr1 set packetSize_ 500
$cbr1 set rate_ 2Mbps
$cbr1 attach-agent $udp1


#udp at 2.

#Create a UDP agent and attach it to node n0
set udp2 [new Agent/UDP]
$ns attach-agent $n2 $udp2
# Create a CBR traffic source and attach it to udp0
set cbr2 [new Application/Traffic/CBR]
$cbr2 set packetSize_ 500
$cbr2 set rate_ 2Mbps
$cbr2 attach-agent $udp2


#CREATE TCP SINKS AT 5 & 6
set null5 [new Agent/TCPSink]
$ns attach-agent $n5 $null5

set null6 [new Agent/TCPSink]
$ns attach-agent $n6 $null6

#create null at 7

set null7 [new Agent/Null]
$ns attach-agent $n7 $null7



#create duplex links
$ns duplex-link $n0 $n3 2Mb 5ms DropTail
$ns duplex-link $n1 $n3 2Mb 5ms DropTail
$ns duplex-link $n2 $n3 2Mb 5ms DropTail

$ns duplex-link $n3 $n4 2Mb 5ms DropTail

$ns duplex-link $n4 $n5 2Mb 5ms DropTail
$ns duplex-link $n4 $n6 2Mb 5ms DropTail
$ns duplex-link $n4 $n7 2Mb 5ms DropTail

#q limit between 3 and 4.

$ns set queue-limit $n3 $n4 10


#connect flow
# 05 , 16 , 27



$ns connect $udp0 $null5
$ns connect $udp1 $null6
$ns connect $udp2 $null7



#start traffic

$ns at 0.1 "$cbr0 start"
$ns at 2.0 "$cbr1 start"
$ns at 7.0 "$cbr2 start"
$ns at 9.0 "$cbr0 stop"
$ns at 9.0 "$cbr1 stop"
$ns at 9.0 "$cbr2 stop"



#finish
$ns at 10.0 "finish"





#Run the simulation
$ns run

