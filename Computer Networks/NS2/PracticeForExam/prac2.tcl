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



for {set i 0} {$i < 7 } {incr i} {

set n$i [$ns node]

} 

#CREATE LINKS

$ns duplex-link $n0 $n1 1Mb 10ms DropTail



#FIX ORIENTATION
$ns duplex-link-op $n0 $n1 orient right-up






$ns at 5.0 "finish"
$ns run
