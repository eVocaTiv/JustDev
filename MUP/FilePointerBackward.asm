.model TINY	
.DATA


fname db 'hohoz.txt' , 0
handle dw ?
line db 0dh , 0ah
string db 'Kunal'
id db 12 dup(?)
hostel db 3 dup(?)
nfname DB 'hohoz.txt' , 0
op db 2 dup(?)

.CODE
.STARTUP	


	;OPEN EXISTING FILE TO READ FROM.
	MOV AH , 3DH
	MOV AL , 02H
	LEA DX , fname
	int 21h
	
	;SAVE HANDLE 
	mov handle , ax		

	
	
	;MOVE FILE POINTER 2 UNITS BEFORE END.
	MOV AH , 42H
	MOV AL , 02H
	MOV BX , handle
	MOV CX , 0FFFFH
	MOV DX , 0FFFEH
	INT 21H
	
	;READ 2 CHARACTERS FROM END OF FILE.
	MOV AH , 3FH
	MOV BX , handle
	MOV CX , 02H
	LEA DX , op
	int 21h	
	
	;APPEND $ SIGN AT END OF READ INPUT.
	lea di , op
	mov cx , 02h
	
ag:	inc di
	dec cx
	jnz ag
	
	;now we are at end of the input.
	;simply add character $ at dx now.
	mov al , '$'
	mov [di] , al
	
	;DISPLAY ALL THE CHARACTER USING THE DISPLAY STRING COMMAND.
	lea dx , op
	mov ah , 09h
	int 21h
	
	;CLOSE FILE
	MOV AH , 3EH
	MOV BX , handle
	INT 21H


	


.EXIT
END
