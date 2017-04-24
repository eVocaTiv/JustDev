.model tiny 
.data
cah db '%'
WCNT DB 0AH

.code
.startup

 Mov      al, 12h
              mov      ah, 0
              int         10h     ; set graphics video mode.


mov dx,240 ; ROW 
mov cx,639 ; COLUMN


FILLHALF1 : MOV CX , 639
	FILLINE1 : 
			
			;FILL PIXEL
			MOV AH , 0CH
			MOV AL , 10010011B
			INT 10H
			
			DEC CX
			JNZ FILLINE1
			
			DEC DX
			JNZ FILLHALF1
			
			
MOV DX , 479
MOV CX , 639			
			
FILLHALF2 : MOV CX , 639
	FILLINE2 : 
			
			;FILL PIXEL
			MOV AH , 0CH
			MOV AL , 10010101B
			INT 10H
			
			DEC CX
			JNZ FILLINE2
			
			DEC DX
			CMP DX , 240
			JNZ FILLHALF2

	;INIT CURSOR POSITION.		
	MOV DH , 00H
	MOV DL , 00H
			
PRINT:
	;SET CURSOR POSITION
	MOV AH , 02H
	INC DL
	MOV BH , 00
	INT 10H
			
			
			
	;INPUT CHARACTER FROM USER
	MOV AH , 08H
	INT 21H
	
	
	
	;WRITE CHAR AT CURSOR POSITION
	MOV AH , 09H
	MOV BH , 00H
	MOV BL , 10010011B
	MOV CX , 01H
	INT 10H
	
	DEC WCNT
	JNZ PRINT
	
			
			;BLOCKING FUNCTION
BLK:
			MOV AH , 07H
			INT 21H
			CMP AL , '%'
			JNZ BLK
			
			
			
.exit
end
