.model tiny
.DATA
fname db 'det.txt' , 0
nfname db 'avinash.txt' , 0
STR1 DB 'HELLO'
handle dw ?
sid db 'a' , 'b' , 'c'
line db 0dh , 0ah
id db 3 dup(?)
RCNT DW 190H
CNT DW 0050H
RECT DB 02H
.CODE
.STARTUP

	
	;SET GRAPHICS DISPLAY MODE
	MOV AH , 00H
	MOV AL , 12H
	INT 10H
	
	
	
	;INITIALIZE PIXEL POSITION.
	MOV CX , 0105H
	MOV DX , 0080H
	jmp FILPIX1


MAKERECT:
	
	INC CX
	INC DX

	
	;(FILL 1 PIXEL) !!
FILPIX1:

	MOV AH , 0CH
	MOV AL , 10001011B
	INT 10H
	
	;(CONTINUE LOOP FOR NEXT PIXEL)
	INC CX
	DEC CNT
	JNZ FILPIX1
	;PIXELLINE 1 END.
	
	
	
	MOV CNT , 0050H
	
	;(FILL 1 PIXEL) !!
FILPIX2:

	MOV AH , 0CH
	MOV AL , 10001011B
	INT 10H
	
	;(CONTINUE LOOP FOR NEXT PIXEL)
	INC DX
	DEC CNT
	JNZ FILPIX2
	;PIXELLINE 2 END.	

	MOV CNT , 0050H
	;(FILL 1 PIXEL) !!
FILPIX3:

	MOV AH , 0CH
	MOV AL , 10001011B
	INT 10H
	
	;(CONTINUE LOOP FOR NEXT PIXEL)
	DEC CX
	DEC CNT
	JNZ FILPIX3
	;PIXELLINE 1 END.
	
	MOV CNT , 0050H
	
	;(FILL 1 PIXEL) !!
FILPIX4:

	MOV AH , 0CH
	MOV AL , 10001011B
	INT 10H
	
	;(CONTINUE LOOP FOR NEXT PIXEL)
	DEC DX
	DEC CNT
	JNZ FILPIX4
	

	;INITIALIZE PIXEL POSITION.
	;MOV CX , 0105H
;	MOV DX , 0080H
	
;	DEC RECT
	;JNZ MAKERECT
		
	
	
		
	
	;BLOCKING FUNCTION WITH %
	MOV AH , 07H
BLOCK:
	INT 21H
	CMP AL , '%'
	JNZ BLOCK

	
	
	

.EXIT
END