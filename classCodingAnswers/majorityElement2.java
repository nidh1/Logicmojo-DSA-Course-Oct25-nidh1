class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> lst = new ArrayList<>();
        Integer s1=null;
        Integer s2=null;
        Integer c1=0;
        Integer c2=0;

        for(int num: nums){
            if(s1!=null && s1==num){
                c1++;
            }else if(s2!=null && s2==num){
                c2++;
            }else if(s1==null){
                s1=num;
            }else if(s2==null){
                s2=num;
            }else {
                if(c1>0){
                   c1--;
                }else{
                    s1=null;
                }

                if(c2>0){
                   c2--;
                }else{
                    s2=null;
                }
            }
        }

        c1=0;
        c2=0;

        for(int n: nums){
            if(s1!=null && n==s1){
                c1++;
            }
            if(s2!=null && n==s2){
                c2++;
            }
        }

        if(c1 > nums.length/3){
            lst.add(s1);
        }

        if(c2 > nums.length/3){
            lst.add(s2);
        }

        return lst;
    }
}
