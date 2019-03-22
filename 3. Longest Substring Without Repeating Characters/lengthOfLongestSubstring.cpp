class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int i=0,j=0,len,answer=0,al=1,ar=1,num=0;
        bool flag[257];
        len = s.length();
        memset(flag,0,sizeof(flag));
        while (j < len) {
            if (flag[int(s[j])]) {
                do
                {
                    flag[int(s[i])]=false;
                    ++i;
                    --num;
                } while ((s[i-1]!=s[j]) && i<j);
            }
            ++num;
            if (num>answer) {
                al=i;
                ar=j;
                answer=num;
            }
            flag[int(s[j])]=true;
            ++j;   
        }
        for (i=al;i<=ar;i++)    printf("%c",s[i]);
        printf("\n");
        return(answer);
    }
};
