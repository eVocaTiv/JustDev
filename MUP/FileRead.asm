.model tiny
.DATA
fname1 db 'xc.txt' , 0
fname2 db 'file1.txt' , 0
dat1 db "DEWAN     "
dat2 db "KUNAL"
dat3 db 5 dup(?)
handle dw ?
.CODE
.STARTUP
	mov ah , 3dh
	mov al , 00h
	lea dx , fname1
	int 21h
	mov handle ,ax
	

	mov ah , 3fh
	mov bx , handle
	mov cx , 5
	lea dx  , dat3
	int 21h
	
	mov ah , 3eh
	mov bx , handle
	int 21h
	

.EXIT
END
