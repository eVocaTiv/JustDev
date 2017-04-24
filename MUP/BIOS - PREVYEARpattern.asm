.model tiny 
.data
cah db '%'
WCNT DB 0AH
GCNT DB 12H
MCNT DB 12H

.code
.startup

;USER INPUT
MOV AH , 01H
INT 21H
mov bl , al




 Mov      al, 12h
          mov ah, 0
          int 10h     ; set graphics video mode.


mov dx,19 ; ROW 
mov cx,639 ; COLUMN


CMP bl , 30H
JZ SEQ2


; SEQUENCE 1
SEQ1:
FILLHALF1 : MOV CX , 639
	FILLINE1 : 
			
			;FILL PIXEL
			MOV AH , 0CH
			MOV AL , 02h
			INT 10H
			
			DEC CX
			JNZ FILLINE1
			
			DEC DX
			JNZ FILLHALF1
			
			

			
			
MOV DX , 38
MOV CX , 639			
			
FILLHALF2 : MOV CX , 639
	FILLINE2 : 
			
			;FILL PIXEL
			MOV AH , 0CH
			MOV AL , 05h
			INT 10H
			
			DEC CX
			JNZ FILLINE2
			
			DEC DX
			CMP DX , 19
			JNZ FILLHALF2

			
MOV DX , 57
MOV CX , 639			
			
FILLHALF3 : MOV CX , 639
	FILLINE3 : 
			
			;FILL PIXEL
			MOV AH , 0CH
			MOV AL , 02h
			INT 10H
			
			DEC CX
			JNZ FILLINE3
			
			DEC DX
			CMP DX , 38
			JNZ FILLHALF3
	
			
MOV DX , 76
MOV CX , 639			
			
FILLHALF4 : MOV CX , 639
	FILLINE4 : 
			
			;FILL PIXEL
			MOV AH , 0CH
			MOV AL , 05h
			INT 10H
			
			DEC CX
			JNZ FILLINE4
			
			DEC DX
			CMP DX , 57
			JNZ FILLHALF4
	
			
MOV DX , 95
MOV CX , 639			
						
FILLHALF5: MOV CX , 639
	FILLINE5 : 
			
			;FILL PIXEL
			MOV AH , 0CH
			MOV AL , 02h
			INT 10H
			
			DEC CX
			JNZ FILLINE5
			
			DEC DX
			CMP DX , 76
			JNZ FILLHALF5
	
			
			
			;BLOCKING FUNCTION
BLK:
			MOV AH , 07H
			INT 21H
			CMP AL , '%'
			JNZ BLK
			
			JMP FIN	


; SEQUENCE 2
SEQ2:
FILLHALF21 : MOV CX , 639
	FILLINE21 : 
			
			;FILL PIXEL
			MOV AH , 0CH
			MOV AL , 05h
			INT 10H
			
			DEC CX
			JNZ FILLINE21
			
			DEC DX
			JNZ FILLHALF21
			
			

			
			
MOV DX , 38
MOV CX , 639			
			
FILLHALF22 : MOV CX , 639
	FILLINE22 : 
			
			;FILL PIXEL
			MOV AH , 0CH
			MOV AL , 02h
			INT 10H
			
			DEC CX
			JNZ FILLINE22
			
			DEC DX
			CMP DX , 19
			JNZ FILLHALF22

			
MOV DX , 57
MOV CX , 639			
			
FILLHALF23 : MOV CX , 639
	FILLINE23 : 
			
			;FILL PIXEL
			MOV AH , 0CH
			MOV AL , 05h
			INT 10H
			
			DEC CX
			JNZ FILLINE23
			
			DEC DX
			CMP DX , 38
			JNZ FILLHALF23
	
			
MOV DX , 76
MOV CX , 639			
			
FILLHALF24 : MOV CX , 639
	FILLINE24 : 
			
			;FILL PIXEL
			MOV AH , 0CH
			MOV AL , 02h
			INT 10H
			
			DEC CX
			JNZ FILLINE24
			
			DEC DX
			CMP DX , 57
			JNZ FILLHALF24
	
			
MOV DX , 95
MOV CX , 639			
						
FILLHALF25: MOV CX , 639
	FILLINE25 : 
			
			;FILL PIXEL
			MOV AH , 0CH
			MOV AL , 05h
			INT 10H
			
			DEC CX
			JNZ FILLINE25
			
			DEC DX
			CMP DX , 76
			JNZ FILLHALF25
	
			
			
			;BLOCKING FUNCTION
BLK2:
			MOV AH , 07H
			INT 21H
			CMP AL , '%'
			JNZ BLK2
			
			
			
FIN:			
.exit
end
