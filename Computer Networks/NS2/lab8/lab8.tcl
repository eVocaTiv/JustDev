set ns [new Simulator]

#CREATE HANDLE FOR TRACE FILE.

set nf [open lab8.nam w]
$ns namtrace-all $nf


#CREATE PROCEDURE FINISH.
proc finish {} {
	global ns nf
	$ns flush-trace
	close $nf
	exec nam lab8.nam &
	exit 0
}

#CREATE NODES
for {set i 0} {$i < 7} {incr i} {
set n($i) [$ns node]
}


#CREATE CIRCULAR TOPOLOGY LINKS
#for {set i 0} {$i < 7} {incr i} {
#$ns duplex-link $n($i) $n([expr ($i+1)%7]) 1Mb 15ms DropTail
#}

#ADD LINKS

$ns duplex-link $n(3) $n(4) 1Mb 15ms DropTail
$ns duplex-link $n(3) $n(2) 1Mb 15ms DropTail
$ns duplex-link $n(3) $n(6) 1Mb 15ms DropTail
$ns duplex-link $n(6) $n(0) 1Mb 15ms DropTail
$ns duplex-link $n(6) $n(5) 1Mb 15ms DropTail
$ns duplex-link $n(2) $n(0) 1Mb 15ms DropTail
$ns duplex-link $n(1) $n(0) 1Mb 15ms DropTail
$ns duplex-link $n(2) $n(5) 1Mb 15ms DropTail
$ns duplex-link $n(2) $n(1) 1Mb 15ms DropTail
$ns duplex-link $n(5) $n(4) 1Mb 15ms DropTail


#ESTABLISH LINK.
#$ns duplex-link $n0 $n2 1Mb 10ms DropTail

#SEND SOME DATA FROM NODE 0 TO NODE 3.

set udp0 [new Agent/UDP]

$ns attach-agent $n(0) $udp0


# Create a CBR traffic source and attach it to udp0
set cbr0 [new Application/Traffic/CBR]
$cbr0 set packetSize_ 500
$cbr0 set interval_ 0.005
$cbr0 attach-agent $udp0

#CREATE NULL AGENT AND ATTACH TO n3.
set null0 [new Agent/Null]
$ns attach-agent $n(3) $null0
#MAKE N0 AS SENDER.
$ns connect $udp0 $null0



$ns at 0.2 "$cbr0 start"
$ns at 4.8 "$cbr0 stop"

#LINK B/W 1 AND 2 GOES DOWN.
$ns rtmodel-at 1.0 down $n(0) $n(2)
$ns rtmodel-at 2.0 down $n(3) $n(6)
$ns rtmodel-at 3.0 up $n(0) $n(2)
$ns rtmodel-at 4.0 up $n(3) $n(6)
$ns rtmodel-at 4.5 down $n(1) $n(2)
$ns rtmodel-at 4.5 down $n(3) $n(6)


#DYNAMIC ROUTING PROTOCOL
$ns rtproto DV

$ns at 5.0 "finish"

$ns run
