/* ̰�����н�����*/
public enum Direction {
	UP(0),
    RIGHT(1),
    DOWN(2),
    LEFT(3);

	// ��Ա����
    private final int directionCode;
    
    // ��Ա����
    public int directionCode() {
        return directionCode;
    }

	// ���캯��
    Direction(int directionCode) {
        this.directionCode = directionCode;
    }
    
    //����ƥ��
    public boolean compatibleWith(Direction newDirection){
    	if (newDirection.directionCode == this.directionCode){
    		return true;
    	}else{
    		return false;
    	}
    }
}
