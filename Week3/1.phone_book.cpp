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
    map<number, string> hashVector(1e5);
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
            
            for (size_t i = 0; i < hashVector.size(); i++){
                if(hashVector[i]==number){
                    cout<<hashVector[i].second<<endl;
                    flag = false;
                    break;
                }
            }
            if(flag){
                cout<<"not found"<<endl;
                continue;
            }
        }
        if(action=="del"){
            for (size_t i = 0; i < hashVector.size(); i++){
                if(hashVector[i].first==number){
                    hashVector.erase(hashVector.begin()+i);
                    break;
                }
            }
        }
    }
    
}