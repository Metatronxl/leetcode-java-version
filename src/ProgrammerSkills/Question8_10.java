package ProgrammerSkills;

public class Question8_10 {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int x = image.length;
        int y = image[0].length;
        if((sr < 0 || sr >= x) || (sc < 0 || sc >= y)){
            return image;
        }
        int oldColor = image[sr][sc];
        return floodFill(image,sr,sc,oldColor,newColor);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int oloColor,int newColor) {
        int x = image.length;
        int y = image[0].length;
        if((sr < 0 || sr >= x) || (sc < 0 || sc >= y)){
            return image;
        }
        if(image[sr][sc] == oloColor && image[sr][sc] != newColor){
            image[sr][sc] = newColor;
            image = floodFill(image,sr-1,sc,oloColor,newColor);
            image = floodFill(image,sr+1,sc,oloColor,newColor);
            image = floodFill(image,sr,sc-1,oloColor,newColor);
            image = floodFill(image,sr,sc+1,oloColor,newColor);
        }
        return image;
    }
}
