#include<stdio.h>
#include<sys/socket.h>
#include<arpa/inet.h>
#include<string.h>
#include<netdb.h>
#include<errno.h>

#define MAXBUF 1024
#define SERVER "0.0.0.0"
#define PORT 10004

int main()
{
int sock,connection;
struct sockaddr_in dest;

if( (sock=socket(AF_INET,SOCK_STREAM,0)) < 0)
{
	perror("socket");
	exit(1);
}

bzero(&dest,sizeof(dest));
dest.sin_family = AF_INET;
dest.sin_port = htons(PORT);

if( inet_aton(SERVER,&dest.sin_addr.s_addr) == 0)
{
	perror("SERVER ADDRESS");
	exit(1);
}
connect(sock,(struct sockaddr*)&dest,sizeof(dest));

char query[MAXBUF];
char *template="GET /index.html HTTP/1.0\r\n\r\n";
sprintf(query,template);

printf("Query:%s\n",query);

send(sock,query,sizeof(query),0);

char buffer[6000],buffer1[6000],buffer2[6000],buffer3[6000],buffer4[6000],buffer5[6000];
//bzero(buffer,sizeof(buffer));
printf("HTTP server reply:\n"); 
recv(sock,buffer,sizeof(buffer),0);
recv(sock,buffer1,sizeof(buffer1),0);
recv(sock,buffer2,sizeof(buffer2),0);
recv(sock,buffer3,sizeof(buffer3),0);
recv(sock,buffer4,sizeof(buffer4),0);
recv(sock,buffer5,sizeof(buffer5),0);
puts(buffer);
puts(buffer1);
puts(buffer2);
puts(buffer3);
puts(buffer4);
puts(buffer5);
close(sock);
}



