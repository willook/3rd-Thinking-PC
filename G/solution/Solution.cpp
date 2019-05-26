#include <stdio.h>
#include <assert.h>
#include <algorithm>

using namespace std;

int check(int k, int n, int l, int arr[], int mid) {
  	int current_block=0;
  	int current_length=0;
  	int i=0;
  	
  	while(1){
  		//printf("%d %d\n",current_length, mid);
  		current_length += mid;
		while(arr[i]<current_length){
			i++;
			if(i==n+1) return 0;
		}
  		current_length = arr[i];
  		current_block++;
  		if(current_block == k+1) return 1; 		
	} 	
    return 0;
}

int* solve(int TC, int n, int l, int arr[],int Q[]){
	int ret[TC];
	for(int tc=0;tc<TC;tc++){
		int k = Q[tc];
		int left = 1;
		int right = l;
		int mid = -1;
		while(left <= right){
			int mid = (left+right)/2;
			if(!check(k,n,l,arr,mid))
				right = mid-1;
			else if(check(k,n,l,arr,mid+1))
				left = mid+1;
			else{
				ret[tc] = mid;
				printf("%d\n",mid);
				break;
			}
		}
	}
	return ret;
}

int solve2(int k, int n, int l, int arr[]){
	for(int mid=1;mid<=l;mid++){
		if(!check(k,n,l,arr,mid))
			return mid-1;
	}
	return -1;
}
int main() {
    int k,n,l;
    scanf("%d%d%d", &k,&n,&l);
    
    int arr[n+1];
    int Q[k];
    for(int i=0;i<n;i++){
		scanf("%d", &arr[i]);
	}
	for(int i=0;i<k;i++){
		scanf("%d", &Q[i]);
	}
	
	arr[n] = l;
    
	assert(1 <= k && k <= 10000);
    assert(k <= n && n <= 10000);
    assert(n <= l && l <= 4000000);
    
	for(int i=0;i<n;i++)
		assert(1 <= arr[i] && arr[i] < l);
	for(int i=0;i<n-1;i++)
		assert(arr[i] < arr[i+1]);
    for(int i=0;i<k;i++)
		assert(1 <= Q[i] && Q[i] <= n);
	for(int i=0;i<k-1;i++)
		assert(Q[i] < Q[i+1]);
    
	
	int* ret = solve(k,n,l,arr,Q);
	//for(int i=0;i<k;i++){
	//	printf("%d\n", ret[i]);
	//}

    return 0;
}