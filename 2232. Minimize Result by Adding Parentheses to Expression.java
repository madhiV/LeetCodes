class Solution {
    public String minimizeResult(String expression) {
        int plusPosition=findPlusPosition(expression);
        int minimumSum=Integer.MAX_VALUE;
        String minimumResult="";
        for(int leftPosition=plusPosition-2;leftPosition>=-1;leftPosition--){
            for(int rightPosition=plusPosition+2;rightPosition<=expression.length();rightPosition++){
                int currentSum=evaluateSum(expression,leftPosition,plusPosition,rightPosition);
                if(currentSum<minimumSum){
                    minimumResult=getExpression(expression,leftPosition,plusPosition,rightPosition);
                    minimumSum=currentSum;
                }
            }
        }
        return minimumResult;
    }
    public int evaluateSum(String expression,int leftPosition,int plusPosition,int rightPosition){
        int num1,num2,num3,num4;
        num1=num2=num3=num4=0;
        num2=Integer.parseInt(expression.substring(leftPosition+1,plusPosition));
        num3=Integer.parseInt(expression.substring(plusPosition+1,rightPosition));
        int sum=num2+num3;
        if(leftPosition!=-1){
            num1=Integer.parseInt(expression.substring(0,leftPosition+1));
            sum*=num1;
        }
        if(rightPosition!=expression.length()){
            num4=Integer.parseInt(expression.substring(rightPosition,expression.length()));
            sum*=num4;
        }
        return sum;
    }
    public String getExpression(String expression,int leftPosition,int plusPosition,int rightPosition){
        StringBuilder sb=new StringBuilder();
        for(int index=0;index<=leftPosition;index++){
                sb.append(expression.charAt(index));
        }
        sb.append("(");
        sb.append(expression.substring(leftPosition+1,plusPosition));
        sb.append("+");
        sb.append(expression.substring(plusPosition+1,rightPosition));
        sb.append(")");
        for(int index=rightPosition;index<expression.length();index++){
            sb.append(expression.charAt(index));
        }
        return sb.toString();
    }
    public int findPlusPosition(String expression){
        int index=0;
        while(expression.charAt(index)!='+'){
            index++;
        }
        return index;
    }
}
