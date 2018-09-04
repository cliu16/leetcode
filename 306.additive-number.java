class Solution {
    public boolean isAdditiveNumber(String num) {
	if(num == null || num.length() == 0){
	    return false;
	}
	
	for(int i = 1; i < num.length(); i++){
	    for(int j = i + 1; j < num.length(); j++){
		String a = num.substring(0, i);
		String b = num.substring(i, j);
		if(isAdditiveNum(a, b, num.substring(j))){
		    return true;
		}
	    }
	}
	
	return false;
    }

    private boolean isAdditiveNum(String a, String b, String c){
	if(c.length() == 0){
	    return true;
	}

	if((a.length() > 1 && a.charAt(0) == '0') || (b.length() > 1 && b.charAt(0) == '0')){
	    return false;
	}

	String sum = add(a, b);
	if(!c.startsWith(sum)){
	    return false;
	}else{
	    return isAdditiveNum(b, sum, c.substring(sum.length()));
	}
    }

    private String add(String a, String b){
	int ap = a.length() - 1, bp = b.length() - 1;
	int carry = 0;
	StringBuilder sb = new StringBuilder();
	while(ap >= 0 || bp >= 0){
	    int aCur = ap >= 0 ? a.charAt(ap) - '0' : 0;
	    int bCur = bp >= 0 ? b.charAt(bp) - '0' : 0;
	    int sum = aCur + bCur + carry;
	    sb.append(sum % 10);
	    carry = sum / 10;
	    ap--;
	    bp--;
	}

	if(carry == 1){
	    sb.append(carry);
	}

	return sb.reverse().toString();
    }
}
