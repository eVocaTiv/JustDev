#include <bits/stdc++.h>
using namespace std;
class Lock
{
	
    private : int top , x , y , z;		
    bool isLocked = false;
    bool  isxdone = false;
    bool  isydone = false;
    bool  iszdone = false;
    int nextdirection = 0;
    // Member Functions()
    Lock(int a , int b, int c , int d){
	top = a;
	x=b;
	y=c;
	z=d;
    }
   //functions
   
   void alter(int n1 , int n2 , int n3){
   	x=n1;
   	y=n2;
   	z=n3;
   	isLocked = false;
   	
   }
   
   void rotateToTop(int direction , int num){
   	top = num;
   	if(direction==1 && direction == nextdirection){
   		if(num==x)
   			isxdone = true;
   		else
   		if(num==y)
   			isydone==true;
   		else
   		if
   		  (num==z)  iszdone = true;
   		  
		nextdirection = 0;
   	}	
   	   //rotate counterclockwise
   	else
   	if(direction == 0 && direction == nextdirection){
   		if(num==x)
   			isxdone = true;
   		else
   		if(num==y)
   			isydone==true;
   		else
   		if
   		  (num==z)  iszdone = true;
   		  
		nextdirection = 1;
   	}//rotate clockwise
   	
   	
   	
   }
   void closeLock(){
   	isLocked = true;
   	isxdone = false;
   	isydone = false;
   	iszdone = false;
   	
   }
   
   bool checkLock(){
   	if(isxdone && isydone && iszdone)
   		isLocked = false;
   	return isLocked;
   	
   }
   
   int getTop(){
   	return top;
   }
   
   
    
};
 
int main() {
 
    
}
