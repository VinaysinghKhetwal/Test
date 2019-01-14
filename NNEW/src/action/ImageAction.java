package action;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class ImageAction extends ActionSupport {
	private File userImage;
	private String userImageContentType;
	private String userImageFileName;

	public String execute() {
		try {
			String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("userimages");

			System.out.println("Image Location:" + filePath);// see the server console for actual location
			File fileToCreate = new File(filePath, userImageFileName);
			FileUtils.copyFile(userImage, fileToCreate);// copying source file to new file
			return "success";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}

	public File getUserImage() {
		return userImage;
	}

	public void setUserImage(File userImage) {
		this.userImage = userImage;
	}

	public String getUserImageContentType() {
		return userImageContentType;
	}

	public void setUserImageContentType(String userImageContentType) {
		this.userImageContentType = userImageContentType;
	}

	public String getUserImageFileName() {
		return userImageFileName;
	}

	public void setUserImageFileName(String userImageFileName) {  
	        this.userImageFileName = userImageFileName;  
	    }
}