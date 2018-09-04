class Solution {
    public int minArea(char[][] image, int x, int y) {
	if(image == null || image.length == 0 || image[0].length == 0){
	    return 0;
	}

	int m = image.length;
	int n = image[0].length;

	int left = findLeft(image, 0, y);
	int right = findRight(image, y, n - 1);
	int top = findTop(image, 0, x);
	int bottom = findBottom(image, x, m - 1);

	return (right - left + 1) * (bottom - top + 1);
    }

    private int findLeft(char[][] image, int start, int end){
	while(start + 1 < end){
	    int mid = start + (end - start)/2;
	    if(isEmptyCol(image, mid)){
		start = mid;
	    }else{
		end = mid;
	    }
	}

	if(isEmptyCol(image, start)){
	    return end;
	}else{
	    return start;
	}
    }

    private int findRight(char[][] image, int start, int end){
	while(start + 1 < end){
	    int mid = start + (end - start)/2;
	    if(isEmptyCol(image, mid)){
		end = mid;
	    }else{
		start = mid;
	    }
	}

	if(isEmptyCol(image, end)){
	    return start;
	}else{
	    return end;
	}
    }

    private int findTop(char[][] image, int start, int end){
	while(start + 1 < end){
	    int mid = start + (end - start)/2;
	    if(isEmptyRow(image, mid)){
		start = mid;
	    }else{
		end = mid;
	    }
	}

	if(isEmptyRow(image, start)){
	    return end;
	}else{
	    return start;
	}
    }

    private int findBottom(char[][] image, int start, int end){
	while(start + 1 < end){
	    int mid = start + (end - start)/2;
	    if(isEmptyRow(image, mid)){
		end = mid;
	    }else{
		start = mid;
	    }
	}

	if(isEmptyRow(image, end)){
	    return start;
	}else{
	    return end;
	}
    }

    private boolean isEmptyCol(char[][] image, int col) {
        for (int i = 0; i < image.length; i++) {
            if (image[i][col] == '1') {
                return false;
            }
        }
        return true;
    }
    
    private boolean isEmptyRow(char[][] image, int row) {
        for (int j = 0; j < image[0].length; j++) {
            if (image[row][j] == '1') {
                return false;
            }
        }
        return true;
    }
}
