package forum.admin.controller;

import com.sun.xml.internal.ws.api.pipe.NextAction;

public class PageCut {
	private final int PAGESIZE=10;
	private int curPage;//��������һҳ
	private int totalPage;//���м�ҳ
	private int totalNum;//���ж���������
	private int restNum;//ʣ�¶���������δ��ʾ
	private int lastNum;//���һҳ��������
	public PageCut(int totalNum)
	{
		this.curPage=1;
		this.totalNum=totalNum;
		//������һҳ����10ҳ�Ļ���Ҫ����һҳ
		if((this.totalNum%this.PAGESIZE)!=0) this.totalPage=this.totalNum/this.PAGESIZE+1;
		else this.totalPage=this.totalNum/this.PAGESIZE;
		this.restNum=this.totalNum-this.curPage*this.PAGESIZE;
		if((this.lastNum=this.totalNum%this.PAGESIZE)==0&&this.totalNum>=this.PAGESIZE) this.lastNum=this.PAGESIZE;
		
	}

	//��һҳ
	public void nextPage(){
		//����Ѿ������һҳ�ˣ��ͻص���һҳ
		if(this.curPage==this.totalPage){
			this.curPage=1;
			this.restNum=this.totalNum-this.curPage*this.PAGESIZE;
		}else{
			this.curPage++;
			if(this.curPage!=this.totalPage) this.restNum=this.totalNum-this.curPage*this.PAGESIZE;
			else this.restNum=0;
		}
	}
	//��һҳ
	public void previousPage(){
		//����Ѿ��ǵ�һҳ�ˣ��ͻص����һҳ
		if(this.curPage==1){
			this.curPage=this.totalPage;
			this.restNum=0;
		}else{
			this.curPage--;
			this.restNum=this.totalNum-this.curPage*this.PAGESIZE;
		
		}
	}
	//ת��ĳһҳ
	public void turnTo(int pageNum){
		if(pageNum==this.totalNum){
			this.curPage=this.totalPage;
			this.restNum=0;
		}else{
			this.curPage=pageNum;
			this.restNum=this.totalNum-this.curPage*this.PAGESIZE;
		
		}
	}

	/**
	 * @return the curPage
	 */
	public int getCurPage() {
		return curPage;
	}

	/**
	 * @param curPage the curPage to set
	 */
	public void setCurPage(int curPage) {
		this.curPage = curPage;
	}

	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return the totalNum
	 */
	public int getTotalNum() {
		return totalNum;
	}

	/**
	 * @param totalNum the totalNum to set
	 */
	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	/**
	 * @return the restNum
	 */
	public int getRestNum() {
		return restNum;
	}

	/**
	 * @param restNum the restNum to set
	 */
	public void setRestNum(int restNum) {
		this.restNum = restNum;
	}

	/**
	 * @return the pAGESIZE
	 */
	public int getPAGESIZE() {
		return PAGESIZE;
	}

	/**
	 * @return the lastNum
	 */
	public int getLastNum() {
		return lastNum;
	}

	/**
	 * @param lastNum the lastNum to set
	 */
	public void setLastNum(int lastNum) {
		this.lastNum = lastNum;
	}
	
	
}
