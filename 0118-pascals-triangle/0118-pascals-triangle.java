class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0; i<numRows; i++){
            ArrayList<Integer> ans = new ArrayList<>();
            for(int j=0; j<=i; j++){
                if(j==0 || j==i){
                    ans.add(1);
                }else{
                    int values = list.get(i-1).get(j-1) + list.get(i-1).get(j);
                    ans.add(values);
                }
            }
            list.add(ans);
        }
        return list;
    }
}