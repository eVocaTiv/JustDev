#include <stdio.h>
#include <errno.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <string.h>
#include <stdlib.h>

#define MAX_BUFFER 1024
#define PORT 9998

int main(int argc, char ** argv){
	
	
	//INITIALIZE
	int sockfd , clientfd;
	struct sockaddr_in dest , clientaddr;
	
	bzero(&dest , sizeof(dest));
	char buff[MAX_BUFFER];
		
		
	//1. SOCKET()
	
	if( (sockfd = socket(AF_INET, SOCK_STREAM, 0)) < 0 ){
		perror("error");
		exit(errno);
	}
	
	//2.configure address
	
	dest.sin_family = AF_INET;
	dest.sin_port = htons(PORT);
	dest.sin_addr.s_addr = INADDR_ANY;

	//3. bind
	//puts("helo");
	if(bind  (sockfd , (struct sockaddr*)&dest , sizeof(dest))!=0){
		//printf("here");
		perror("socket");
		exit(errno);
		
	}
	else{
		puts("helo3");
		printf("binded");
		}
	//4. listen.
	
	if(listen(sockfd , 20)!=0){
		perror("socket listen");
		exit (errno);
	}
	else{
	//	puts("helo4");
		puts("\n");
		puts("Listening...");
		}
		
	int addrlen = sizeof(clientaddr);
	
	//5.accept
	clientfd = accept(sockfd , (struct  sockaddr*)&clientaddr, &addrlen);
	puts("Connectedto the server!");
	
	//clear buffer
	bzero(&buff , sizeof(buff));
	
	
	//receive into buffer
	recv(clientfd , buff , sizeof(buff) , 0);
	
	//print received message
	printf("Received : \n ");
	printf("%s" , buff);
	
	//6.close connection.
	close(sockfd);
	return 0;	


}
