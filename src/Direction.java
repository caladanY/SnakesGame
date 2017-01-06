/* 贪吃蛇行进方向*/
public enum Direction {
	UP(0),
    RIGHT(1),
    DOWN(2),
    LEFT(3);

	// 成员变量
    private final int directionCode;
    
    // 成员方法
    public int directionCode() {
        return directionCode;
    }

	// 构造函数
    Direction(int directionCode) {
        this.directionCode = directionCode;
    }
    
    //方向匹配
    public boolean compatibleWith(Direction newDirection){
    	if (newDirection.directionCode == this.directionCode){
    		return true;
    	}else{
    		return false;
    	}
    }
}
