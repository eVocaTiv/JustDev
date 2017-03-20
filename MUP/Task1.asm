.model tiny
.DATA
fname db 'det.txt' , 0
handle dw ?
sid db 'a' , 'b' , 'c'
id db 3 dup(?)
.CODE
.STARTUP

	lea di , id
	;CREATE NEW FILE
	mov ah , 3ch
	lea dx , fname
	mov cl , 00h
	int 21h
	mov handle , ax
	
	;INPUT 3 LENGTH ID FROM USER
	mov cx , 3
	lea si , id
sto:

	mov ah , 08h
	int 21h
	mov [si], al
	inc si
	dec cx
	jnz sto		
	
	;WRITE ID TO FILE
	mov ah , 40h
	mov bx , handle
	mov cx , 3
	lea dx , id
	int 21h
	
	;CLOSE FILE

	mov ah , 3eh
	mov bx , handle
	int 21h
	

.EXIT
END
