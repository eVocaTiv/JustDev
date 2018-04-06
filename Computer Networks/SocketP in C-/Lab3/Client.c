#include <stdio.h>
#include <string.h>
#include <errno.h>
#include <sys/socket.h>
#include<netinet/in.h>


#define SERVER_ADDR     "127.0.0.1"     /* localhost */
#define MAXBUF          1024
#define SERV_PORT       3023

int main() {
	int sockfd;
	struct sockaddr_in dest;
	char buffer[MAXBUF];

	//create the socket
	if ((sockfd = socket(AF_INET, SOCK_STREAM, 0)) < 0) {
		perror("Socket");
		exit(errno);
	}

	//equivalent to using memset
	bzero(&dest, sizeof(dest));

	//Address family = Internet
	dest.sin_family = AF_INET;

	//set port number, using htons function to use proper byte order
	dest.sin_port = htons(SERV_PORT);
	if (inet_aton(SERVER_ADDR, &dest.sin_addr.s_addr) == 0) {
		perror(SERVER_ADDR);
		exit(errno);
	}
	
	connect(sockfd,(struct sockaddr*)&dest , sizeof(dest));
	
	
	//connect to the server. Check for error codes
	//your code here

	//Stub. Take input expression from the terminal, send it to the server, receive the result, and display it
	while (1) {
		scanf("%s" , buffer);
		send(sockfd , buffer , sizeof(buffer), 0);
		puts("Sent from client");
		puts(buffer);
		
		char ans[MAXBUF];
		recv(sockfd , ans , sizeof(ans),0);
		puts("Answer received is : " );
		puts(ans);
		//your code here
	}

	/*---Close socket---*/
	close(sockfd);
	return 0;
}
