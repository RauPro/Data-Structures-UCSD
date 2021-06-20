#include <bits/stdc++.h>
using namespace std;

#define Fast ios::sync_with_stdio(0); cin.tie(0);


typedef long long ll;
typedef long int li;
typedef vector<int> vi;
typedef vector<ll> vl;
typedef pair<int, string> psi;

int main(){
	Fast
    int t; cin>>t;
    map<int, string> hashVector;
    test:while (t--){
        string action;cin>>action;
        int number;cin>>number;
        string refName;
        if(action=="add"){
            cin>>refName;
            hashVector[number]=refName;
            continue;
        }
        if(action=="find"){
            bool flag = true;
            if(hashVector.count(number)){
                cout<<hashVector.find(number)->second<<endl;
            }else{
                cout<<"not found"<<endl;
            }
        }
        if(action=="del"){
            hashVector.erase(number);
        }
    }
    
}