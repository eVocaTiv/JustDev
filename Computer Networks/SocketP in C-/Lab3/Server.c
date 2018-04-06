#include <stdio.h>
#include <errno.h>
#include <stdbool.h>
#include<netinet/in.h>
#include <sys/socket.h>
#include <arpa/inet.h>
#include <string.h>

#define EVAL_PORT	3023
#define MAXBUF		1024

// A utility function to check if a given character is operand (+,-,*,/)
//This method is a stub
bool isOperand(char c) {
	return (c=='+' || c=='*' || c=='-' || c=='/');
	//your code here
	
}

// utility function to find value of and operand
//This method is a stub
int value(char c) {
	//your code here
	return -1;
}

// This function evaluates simple expressions. It returns -1 if the given expression is invalid.
//This method is a stub
int evaluate(char *exp) {
	//your code here
	return 5;
}

int main(int Count, char *Strings[]) {
	int sockfd;
	struct sockaddr_in addr;
	char buffer[MAXBUF];

	sockfd = socket (AF_INET , SOCK_STREAM , 0);
	addr.sin_family = AF_INET;
	addr.sin_addr.s_addr = INADDR_ANY;
	addr.sin_port = htons(EVAL_PORT);
	
	bind(sockfd , (struct sockaddr*)&addr , sizeof(addr));
	
	//create the socket, configure the address and bind the socket to the address
	//your code here
	while (1) {
		
		//Listen on the socket, with 20 max connection requests queued
		if (listen(sockfd, 20) != 0) {
			perror("socket--listen");
			exit(errno);
		} else {
			printf("Listening\n");
		}
		int clientfd;
		struct sockaddr_in client_addr;
		int addrlen = sizeof(client_addr);

		//accept a connection
		clientfd = accept(sockfd, (struct sockaddr*) &client_addr, &addrlen);
		
		//print the IP address and the port of the client(the port is NOT EVAL_PORT
		//your code here

		bzero(&buffer, sizeof(buffer));
		recv(clientfd, buffer, sizeof(buffer), 0);	//no flags specified
		puts("Received message  : ");
		puts(buffer);
		int result = evaluate(buffer);

		//send(clientfd , buffer , sizeof(buffer),0);
		send(clientfd , result , 5 ,0);
		
		puts("Result sent  from client is : ");
		puts("\n");
		printf("%d" , result);
		//send the results back to the connected client
		//your code here

	}

	close(sockfd);
	return 0;
}
