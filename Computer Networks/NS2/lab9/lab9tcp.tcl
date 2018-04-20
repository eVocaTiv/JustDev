#Create a simulator object
set ns [new Simulator]
#Open the nam trace file
set nf [open lab9tcp.nam w]
$ns namtrace-all $nf
#Open the tracefile
set tr [open tracefile.tr w]
$ns trace-all $tr
#Define a 'finish' procedure
proc finish {} {
global ns nf tr
$ns flush-trace
#Close the trace file
close $nf
close $tr
#Execute nam on the trace file
exec nam lab9tcp.nam &
exit 0
}
#Create seven nodes
for {set i 0} {$i < 8} {incr i} {
set n($i) [$ns node]
}
#Create links between the nodes
$ns simplex-link $n(0) $n(1) 2Mb 15ms DropTail
$ns simplex-link $n(1) $n(2) 2Mb 15ms DropTail
$ns simplex-link $n(2) $n(3) 2Mb 15ms DropTail
$ns simplex-link $n(3) $n(0) 2Mb 15ms DropTail

$ns duplex-link $n(0) $n(4) 32Mb 15ms DropTail
$ns duplex-link $n(3) $n(5) 32Mb 15ms DropTail
$ns duplex-link $n(2) $n(6) 32Mb 15ms DropTail
$ns duplex-link $n(1) $n(7) 32Mb 15ms DropTail

$ns queue-limit $n(0) $n(1) 10
$ns queue-limit $n(1) $n(2) 10
$ns queue-limit $n(2) $n(3) 10
$ns queue-limit $n(3) $n(0) 10

###
### INSERT YOUR CODE HERE
###

#create udp and cbr node 4

set udp4 [new Agent/TCP]

$ns attach-agent $n(4) $udp4


# Create a CBR traffic source and attach it to udp4
set cbr4 [new Application/Traffic/CBR]
$cbr4 set packetSize_ 500
$cbr4 set interval_ 0.005
$cbr4 attach-agent $udp4

#create udp and cbr node 5

set udp5 [new Agent/TCP]

$ns attach-agent $n(5) $udp5


# Create a CBR traffic source and attach it to udp5
set cbr5 [new Application/Traffic/CBR]
$cbr5 set packetSize_ 500
$cbr5 set interval_ 0.005
$cbr5 attach-agent $udp5


#create udp and cbr node 6

set udp6 [new Agent/TCP]

$ns attach-agent $n(6) $udp6


# Create a CBR traffic source and attach it to udp6
set cbr6 [new Application/Traffic/CBR]
$cbr6 set packetSize_ 500
$cbr6 set interval_ 0.005
$cbr6 attach-agent $udp6


#create udp and cbr node 7

set udp7 [new Agent/TCP]

$ns attach-agent $n(7) $udp7


# Create a CBR traffic source and attach it to udp7
set cbr7 [new Application/Traffic/CBR]
$cbr7 set packetSize_ 500
$cbr7 set interval_ 0.005
$cbr7 attach-agent $udp7

#--------------------

#CREATE NULL SINK AGENTS.
set null4 [new Agent/TCPSink]
$ns attach-agent $n(4) $null4
set null5 [new Agent/TCPSink]
$ns attach-agent $n(5) $null5
set null6 [new Agent/TCPSink]
$ns attach-agent $n(6) $null6
set null7 [new Agent/TCPSink]
$ns attach-agent $n(7) $null7
#---------------------

#flow paths.

$ns connect $udp4 $null6
$ns connect $udp7 $null5
$ns connect $udp6 $null4
$ns connect $udp5 $null7

#start the traffic 

$ns at 0.2 "$cbr4 start"
$ns at 0.2 "$cbr5 start"
$ns at 0.2 "$cbr6 start"
$ns at 0.2 "$cbr7 start"


$ns at 2.0 "$cbr4 set rate_ 1mbps ***"
$ns at 2.0 "$cbr5 set rate_ 1mbps ***"
$ns at 2.0 "$cbr6 set rate_ 1mbps ***"
$ns at 2.0 "$cbr7 set rate_ 1mbps ***"

$ns at 4.0 "$cbr4 set rate_ 2mbps ***"
$ns at 4.0 "$cbr5 set rate_ 2mbps ***"
$ns at 4.0 "$cbr6 set rate_ 2mbps ***"
$ns at 4.0 "$cbr7 set rate_ 2mbps ***"

$ns at 6.0 "$cbr4 set rate_ 4mbps ***"
$ns at 6.0 "$cbr5 set rate_ 4mbps ***"
$ns at 6.0 "$cbr6 set rate_ 4mbps ***"
$ns at 6.0 "$cbr7 set rate_ 4mbps ***"


$ns at 8.0 "$cbr4 stop"
$ns at 8.0 "$cbr5 stop"
$ns at 8.0 "$cbr6 stop"
$ns at 8.0 "$cbr7 stop"



#Call the finish procedure after 10 seconds of simulation time
$ns at 10.0 "finish"
#Run the simulation
$ns run
