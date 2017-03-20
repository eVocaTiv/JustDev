.model tiny
.DATA
fname1 db 'xc.txt' , 0
fname2 db 'file1.txt' , 0
dat1 db "DEWAN     "
dat2 db "KUNAL"

handle dw ?
.CODE
.STARTUP
	mov ah , 3dh
	mov al , 02h
	lea dx , fname1
	int 21h		
	mov handle , ax
	
	mov ah , 40h
	mov bx , handle
	mov cx , 10
	lea dx , dat1
	int 21h

		
	mov ah , 3eh
	mov bx , handle
	int 21h
	
	
	mov ah , 3dh
	mov al , 02h
	lea dx , fname2
	int 21h		
	mov handle , ax
	
	mov ah , 40h
	mov bx , handle
	mov cx , 5
	lea dx , dat2
	int 21h

		
	mov ah , 3eh
	mov bx , handle
	int 21h

	

.EXIT
END
