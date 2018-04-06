
/**************************************************************************
*   This is a simple client socket reader.  It opens a socket, connects
*   to a server, reads the message, and closes.
**************************************************************************/
#include <stdio.h>
#include <string.h>
#include <errno.h>
#include <sys/socket.h>
#include <netinet/in.h>
#define MAXBUF 1024
#define SERVER_ADDR "127.0.0.1"
#define MY_PORT 9999
int main ()
{
	int sockfd;
	struct sockaddr_in dest;
	char buffer[MAXBUF];
	// Create the socket with three arguments - 
	// 1) Internet Domain 2.) Stream Socket 3.) Default protocol (TCP in this case)
	if((sockfd = socket(AF_INET,SOCK_STREAM,0)) < 0 )
	{
		perror("Socket");
		exit(errno);
	}
	// Configure settings for the server ip address
	bzero(&dest,sizeof(dest));
	// -------- Address family
	dest.sin_family = AF_INET;
	// ----------- Address port ----------------
	dest.sin_port = htons(MY_PORT);

	/* ----  inet_aton() converts the Internet host address cp from the IPv4 numbers-and-dots notation
	   ---- into binary form (in network byte order) and stores it in the structure that inp points to.
	   ---- inet_aton() returns nonzero if the address is valid, zero if not.
	   */

	if(inet_aton(SERVER_ADDR, &dest.sin_addr.s_addr) == 0)
	{
		perror(SERVER_ADDR);
		exit(errno);
	}
	/*---Connect to server---*/
	if(connect(sockfd,(struct sockaddr*)&dest, sizeof(dest)) != 0)
	{
		perror("Connect ");
		exit(errno);
	}
	scanf("%[^\n]s",buffer);
	send(sockfd,buffer,sizeof(buffer),0);
	printf("%s\n",buffer );

	close(sockfd);
	return 0;
};
