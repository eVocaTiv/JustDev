.model tiny
.DATA
fname db 'det.txt' , 0
handle dw ?
sid db 'a' , 'b' , 'c'
line db 0dh , 0ah
inp db 5 dup(?)
id db 3 dup(?)
.CODE
.STARTUP

	;OPEN EXISTING FILE TO WRITE TO.
	MOV AH , 3DH
	MOV AL , 02H
	LEA DX , fname
	int 21h
	
	;SAVE HANDLE 
	mov handle , ax
		
	;MOVE FILE POINTER TO THE END.	
	mov ah , 42h
	mov al , 2h
	mov bx , handle
	mov cx , 0000h
	mov dx , 0000h
	int 21h
	
	;ADD NEXTLINE TO FILE
	mov ah , 40h
	mov bx , handle
	mov cx , 2
	lea dx , line
	int 21h
		
	;INPUT 5 LENGTH NAME FROM USER
	mov cx , 5
	lea si , inp

sto:

	mov ah , 08h
	int 21h
	mov [si], al
	inc si
	dec cx
	jnz sto		
	
	;WRITE TO FILE
	MOV AH , 40H
	MOV BX , handle
	MOV CX , 5
	LEA DX , inp
	int 21h


	;CLOSE FILE

	mov ah , 3eh
	mov bx , handle
	int 21h
	
		
	

.EXIT
END
