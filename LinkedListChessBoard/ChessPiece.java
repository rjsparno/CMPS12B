public abstract class ChessPiece{
   public int row;
   public int col;
   public int color;
   public char letter;
   abstract boolean isAttacking(ChessPiece c);

}
class King extends ChessPiece{
   public King(int c,int r,int bw){
      col = c;
      row = r;
      color = bw;
      if(bw==1){
         letter = 'k';
      }
      else{
         letter = 'K';
      }
   }
   public boolean isAttacking(ChessPiece c){
	  if(col == c.col && row == c.row)
	  {
		  //System.out.println("Same");
		  return false;
	  }
      if((row-c.row<=1)&&(row-c.row>= -1)&&(col-c.col<=1)&&(col-c.col>= -1) && (color!=c.color)){
         return true;
      }
      else{
         return false;
      }
   }
}
class Queen extends ChessPiece{
   public Queen(int c,int r,int bw){
      col = c;
      row = r;
      color = bw;
      if(bw==1){
         letter = 'q';
      }
      else{
         letter = 'Q';
      }

   }
   public boolean isAttacking(ChessPiece c){
	  if(color == c.color)
	  {
		  return false;
	  }
	  if(row == c.row && col == c.col)
	  {
		  return false;
	  }
      if((row == c.row || col == c.col)){
         return true;
      }
      else if (Math.abs(row-c.row) == Math.abs(col - c.col)){
         return true;
      }
      else{
         return false;
      }
   }/*
   private pieces copy(){
      return(new Queen(row,col,color));
   }*/

   
}
class Knight extends ChessPiece{
   public Knight(int c,int r,int bw){
      col = c;
      row = r;
      color = bw;
      if(bw==1){
         letter = 'n';
      }
      else{
         letter = 'N';
      }

   }
   public boolean isAttacking(ChessPiece c){
	   
	  if(color == c.color)
	  {
		  return false;
	  }
	  if(col == c.col && row == c.row)
	  {
		  return true;
	  }
      if((Math.abs(c.col-col)==2)&&((Math.abs(c.row-row))==1)){
         return true;
      }
      else if((Math.abs(c.row-row)==2)&&(Math.abs(c.col-col)==1)){
         return true;
      }
      else{
         return false;
      }
   }
}

class Rook extends ChessPiece{
   public Rook(int c,int r,int bw){
      col = c;
      row = r;
      color = bw;
      if(bw==1){
         letter = 'r';
      }
      else{
         letter = 'R';
      }
      

   }
   public boolean isAttacking(ChessPiece c){
      if(color == c.color){
         return false;
      }
	  if(col == c.col && row == c.row)
	  {
		  return true;
	  }
      if((row==c.row)||(col==c.col)){
      return true;
      }
      else{      
      return false;
      }
   }

}

class Bishop extends ChessPiece{
   public Bishop(int c,int r,int bw){
      col = c;
      row = r;
      color = bw;
      if(bw==1){
         letter = 'b';
      }
      else{
        letter = 'B';
      }

   }
   public boolean isAttacking(ChessPiece c){
	  if(color == c.color)
	  {
		  return false;
	  }
	  if(row == c.row && col == c.col)
	  {
		  return false;
	  }
      if(Math.abs(row-c.row) == Math.abs(col - c.col) && (color != c.color)){
         return true;
      }
      else{
         return false;
      }
   }

}