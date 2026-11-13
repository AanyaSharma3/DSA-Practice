class Solution {
    int k; //frequency
    List<String> res;

    class TrieNode{
        TrieNode children[];
        boolean isWord;

        TrieNode(){
            children = new TrieNode[26];
            isWord = false;
        }
    }

    public void addWords(TrieNode root,String word){
        TrieNode curr = root;
        for(char c:word.toCharArray()){
            if(curr.children[c-'a'] == null){
                curr.children[c-'a']=new TrieNode();
            }
            curr=curr.children[c-'a'];
        }
        curr.isWord=true;
    }

    public void getWords(TrieNode root,String word){
        if(k<=0) return;
        if(root.isWord == true){
            k--;
            res.add(word);
        }

        for(int i=0; i<26; i++){
            if(root.children[i] != null){
                getWords(root.children[i],word+(char)(i+'a'));
            }
        }
    }


    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        this.k = k;
        res = new ArrayList<>();

        TrieNode bucket[] = new TrieNode[n+1];
        HashMap<String,Integer> map = new HashMap<>();

        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        for(var entry:map.entrySet()){
            if(bucket[entry.getValue()] == null){
                bucket[entry.getValue()] = new TrieNode();
            }

            addWords(bucket[entry.getValue()],entry.getKey());
        }

        for(int i=n; i>=1; i--){
            if(bucket[i] != null){
                getWords(bucket[i],"");
            }
            if(this.k==0) break;
        }

        return res;
    }
}