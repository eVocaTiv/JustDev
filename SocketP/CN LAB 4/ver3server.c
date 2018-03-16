/*
$./a.out -p 50000 -r /home/
to start a server at port 50000 with root directory as "/home"


*/

#include<stdio.h>
#include<string.h>
#include<stdlib.h>
#include<unistd.h>
#include<sys/types.h>
#include<sys/stat.h>
#include<sys/socket.h>
#include<arpa/inet.h>
#include<netdb.h>
#include<signal.h>
#include<fcntl.h>

#define CONNMAX 1000
#define BYTES 1024

int badflag = 0;
char *ROOT;
int listenfd, clients[CONNMAX];
void error(char *);
void startServer(char *);
void respond(int);

int main(int argc, char* argv[])
{
	struct sockaddr_in clientaddr;
	socklen_t addrlen;
	char c;    
	
	//Default Values PATH = ~/ and PORT=10000
	char PORT[6];
	ROOT = getenv("PWD");
	strcpy(PORT,"10000");

	int slot=0;

	//Parsing the command line arguments
	while ((c = getopt (argc, argv, "p:r:")) != -1)
		switch (c)
		{
			case 'r':
				ROOT = malloc(strlen(optarg));
				strcpy(ROOT,optarg);
				break;
			case 'p':
				strcpy(PORT,optarg);
				break;
			case '?':
				fprintf(stderr,"Wrong arguments given!!!\n");
				exit(1);
			default:
				exit(1);
		}
	
	printf("Server started at port no. %s%s%s with root directory as %s%s%s\n","\033[92m",PORT,"\033[0m","\033[92m",ROOT,"\033[0m");
	// Setting all elements to -1: signifies there is no client connected
	int i;
	for (i=0; i<CONNMAX; i++)
		clients[i]=-1;
	startServer(PORT);

	// ACCEPT connections
	while (1)
	{	//printf("waiting");
		addrlen = sizeof(clientaddr);
		clients[slot] = accept (listenfd, (struct sockaddr *) &clientaddr, &addrlen);
		//printf("2waiting");
		if (clients[slot]<0)
			error ("accept() error");
		else
		{
			if ( fork()==0 )
			{
				respond(slot);
				exit(0);
			}
		}
		//printf("3waiting");
		while (clients[slot]!=-1) slot = (slot+1)%CONNMAX;
		//printf("slot ++ ");
	}

	return 0;
}

//start server
void startServer(char *port)
{
	struct addrinfo hints, *res, *p;

	// getaddrinfo for host
	memset (&hints, 0, sizeof(hints));
	hints.ai_family = AF_INET;
	hints.ai_socktype = SOCK_STREAM;
	hints.ai_flags = AI_PASSIVE;
	if (getaddrinfo( NULL, port, &hints, &res) != 0)
	{
		perror ("getaddrinfo() error");
		exit(1);
	}
	// socket and bind
	for (p = res; p!=NULL; p=p->ai_next)
	{
		listenfd = socket (p->ai_family, p->ai_socktype, 0);
		if (listenfd == -1) continue;
		if (bind(listenfd, p->ai_addr, p->ai_addrlen) == 0) break;
	}
	if (p==NULL)
	{
		perror ("socket() or bind()");
		exit(1);
	}

	freeaddrinfo(res);

	// listen for incoming connections
	if ( listen (listenfd, 1000000) != 0 )
	{
		perror("listen() error");
		exit(1);
	}
}

//client connection
void respond(int n)
{


	

		printf("\nresponse begins");
	char mesg[99999];
	char buff[99999];
	int rcvd, fd;

	memset( (void*)mesg, (int)'\0', 99999 );

	rcvd=recv(clients[n], mesg, 99999, 0);
	
	
	if (rcvd<0)    // receive error
		fprintf(stderr,("recv() error\n"));
	else if (rcvd==0)    // receive socket closed
		fprintf(stderr,"Client disconnected upexpectedly.\n");
	else    // message received
	{
	
	
	//check VALID HTTP VERSION
	//IF NOT VALID THEN SEND ERROR AND EXIT
	//ELSE CONTINUE.
	
 
    // Returns first token 
    char *token = strtok(mesg, "/");
    char *tokenleft ;
    char *tokenright;
    // Keep printing tokens while one of the
    // delimiters present in str[].
    while (token != NULL)
    {	
        //printf("%s\n", token);
        if(*token == '1'){
        	tokenleft = token+1;
        	tokenright = token+2;
        	if(*tokenleft!='.' || (*tokenright != '1' && *tokenright!= '0')){
        		badflag = 1;
        		printf("bad");
        		send(clients[n], "HTTP/1.0 400 Bad Request", 50 , 0);
        		}
         } 		
        token = strtok(NULL, "/");
       
    }
 
	
		//*buff = ;
		//send(clients[n], "Hello", 5, 0); //
		
		
		//OPEN THE REQUESTED FILE READ FROM THE MESSAGE.
   if(badflag==0){
    FILE *fptr;
    char filename[15];
    char ch;

    /*  open the file for reading */
    fptr = fopen("index.html" ,"r");

    if (fptr == NULL)

    {
    	send(clients[n], "HTTP/1.0 404 Not Found" , 50 , 0);
   
       //printf("Cannot open file \n");
        //exit(0);
    }
    
    else{
	printf("file opened");
    ch = fgetc(fptr);
	int i=0;
   
	int size = 6000;
	int counter = 0;
    while (ch != EOF)
    {
		counter++;
        //printf ("%c", ch);
        buff[i++] = ch;
		
        ch = fgetc(fptr);
		//char ch2 = fgetc(fptr+1);
	// || ch2 == EOF
	if(counter%150 == 0){
		send(clients[n], buff, sizeof(buff), 0);
		i=0;    
    	}
    }
    
    	send(clients[n], buff, sizeof(buff), 0);
    
    if(fptr!=NULL)
    	
			send(clients[n] , "HTTP/1.0 200 OK" , 50 , 0);
			
				
	//send(clients[n], buff, sizeof(buff), 0);
    fclose(fptr);
	}
	printf("\nresponse ended");
		

		
		//REPLY ACCCORDINGLY.
		
		
		//fprintf("Received value %d", rcvd);
		/* write code to respond to HTTP GET queries, The different responses should be
		i)  HTTP/1.0 200 OK (send the corresponding file, in case no filename is specified, index.html should be sent)
		ii) HTTP/1.0 400 Bad Request (invalid HTTP version specified etc., valid versions are HTTP/1.0 and HTTP/1.1)
		iii)HTTP/1.0 404 Not Found (file not found)
		 */
	}
}
	//Closing SOCKET
	shutdown (clients[n], SHUT_RDWR);         //All further send and recieve operations are DISABLED...
	close(clients[n]);
	clients[n]=-1;
}
