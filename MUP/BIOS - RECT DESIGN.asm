.model tiny 
.data
cah db '%'
WCNT DB 0AH

.code
.startup

 Mov      al, 12h
              mov      ah, 0
              int         10h     ; set graphics video mode.


mov dx,480 ; ROW 
mov cx,640 ; COLUMN


FILLHALF1 : MOV CX , 640
	FILLINE1 : 
			
			;FILL PIXEL
			MOV AH , 0CH
			MOV AL , 10010011B
			INT 10H
			
			DEC CX
			JNZ FILLINE1
			
			DEC DX
			JNZ FILLHALF1
			
MOV DX , 380			
FILLHALF2 : MOV CX , 540
	FILLINE2 : 
			
			;FILL PIXEL
			MOV AH , 0CH
			MOV AL , 10010101B
			INT 10H
			
			DEC CX
			CMP CX , 100 
			JNZ FILLINE2
			
			DEC DX
			CMP DX , 70
			JNZ FILLHALF2
			
			
			MOV DX , 300			
FILLHALF3 : MOV CX , 440
	FILLINE3 : 
			
			;FILL PIXEL
			MOV AH , 0CH
			MOV AL , 10010111B
			INT 10H
			
			DEC CX
			CMP CX , 200 
			JNZ FILLINE3
			
			DEC DX
			CMP DX , 130
			JNZ FILLHALF3
						

						

			
			;BLOCKING FUNCTION
BLK:
			MOV AH , 07H
			INT 21H
			CMP AL , '%'
			JNZ BLK
			
			
			
.exit
end
