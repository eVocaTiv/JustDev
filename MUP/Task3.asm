.model tiny
.DATA
fname db 'det.txt' , 0
handle dw ?
op db 10 dup(?)
.CODE
.STARTUP

	;OPEN EXISTING FILE TO READ FROM.
	MOV AH , 3DH
	MOV AL , 02H
	LEA DX , fname
	int 21h
	
	;SAVE HANDLE 
	mov handle , ax

	;FROM START OF FILE , READ N CHARACTERS AND STORE IN LOCATION.
	
	MOV AH , 3FH
	MOV BX , handle
	MOV CX , 0dH
	LEA DX , op
	int 21h
	
	;APPEND $ SIGN AT END OF READ INPUT.
	lea di , op
	mov cx , 0dh
	
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

	mov ah , 3eh
	mov bx , handle
	int 21h
	
		
	

.EXIT
END
