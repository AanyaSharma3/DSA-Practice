class Solution {
    public String rankTeams(String[] votes) {
        HashMap<Character,int[]> track = new HashMap<>();
        int length = votes[0].length();

        for(String vote:votes){
            for(int j=0; j<length; j++){
                char ch = vote.charAt(j);
                track.putIfAbsent(ch,new int[length]);
                track.get(ch)[j]++;
            }
        }

        List<Character> list = new ArrayList<>(track.keySet());
        Collections.sort(list,(a,b)->{
            for(int j=0; j<length; j++){
                if(track.get(a)[j] != track.get(b)[j]){
                    return track.get(b)[j] - track.get(a)[j];
                }
            }
            return a-b;
        });

        StringBuilder sb = new StringBuilder();
        for(char ch:list){
            sb.append(ch);
        }

        return sb.toString();
    }
}