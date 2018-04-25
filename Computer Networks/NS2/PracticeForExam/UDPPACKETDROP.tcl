#CREATE SIM OBJECT
set ns [new Simulator]

#CREATE HANDLE FOR TRACE FILE - 'nf' here

set nf [open out.nam w]
$ns namtrace-all $nf

#CREATE FIN PROC.

proc finish {} {
	global ns nf 
	$ns flush-trace
	close $nf 
	exec nam out.nam &
	exit 0
}

#CREATE NODES

#set n0 [$ns node]
#set n1 [$ns node]



for {set i 0} {$i < 4 } {incr i} {

set n$i [$ns node]

} 

#CREATE LINKS

$ns duplex-link $n0 $n1 2Mb 10ms SFQ
$ns duplex-link $n2 $n1 2Mb 10ms SFQ
$ns duplex-link $n1 $n3 2Mb 10ms SFQ
$ns duplex-link $n3 $n2 2Mb 10ms SFQ



#FIX ORIENTATION
$ns duplex-link-op $n1 $n0 orient left
$ns duplex-link-op $n1 $n2 orient right
$ns duplex-link-op $n1 $n3 orient down
$ns duplex-link-op $n3 $n2 orient up-right

#SET QUEUE LIMIT

$ns queue-limit $n1 $n0 10000


#CREATE TCP AGENTS
set tcp0 [new Agent/UDP]
$ns attach-agent $n0 $tcp0

set cbr0 [new Application/Traffic/CBR]
$cbr0 set packetSize_ 500
$cbr0 set interval_ 0.001
$cbr0 attach-agent $tcp0

set tcp1 [new Agent/UDP]
$ns attach-agent $n0 $tcp1

set cbr1 [new Application/Traffic/CBR]
$cbr1 set packetSize_ 500
$cbr1 set interval_ 0.001
$cbr1 attach-agent $tcp1

#CREATE SINK AGENTS.
set null2 [new Agent/Null]
$ns attach-agent $n2 $null2

set null3 [new Agent/Null]
$ns attach-agent $n3 $null3

#CONNECT PATHS.

$ns connect $tcp0 $null2
$ns connect $tcp1 $null3


$ns at 0.5 "$cbr0 start"
$ns at 0.5 "$cbr1 start"
$ns at 1.0 "$cbr1 set rate_ 1mbps"
#$ns at 1.0 "$cbr0 set rate_ 10.0Mb"


#$ns rtmodel-at 1.5 down $n1 $n2
#$ns rtmodel-at 2.0 up   $n1 $n2
$ns at 4.5 "$cbr0 stop"
$ns at 4.5 "$cbr1 stop"

$ns rtproto DV

$ns at 5.0 "finish"
$ns run
