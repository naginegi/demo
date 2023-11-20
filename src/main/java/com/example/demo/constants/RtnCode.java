package com.example.demo.constants;

public enum RtnCode {

	// �C�| 200 400 401 403 404
	// �䪺��200 �䤣��404 �ѤU400
	// 401 403 ���v������
	SUCCESSFUL(200, "Successful"), // ���\
	PARAM_ERROR(400, "Param_error"), // �Ѽƿ��~
	ACCOUNT_EXISTED(400,"Account_existed"),//�b���w�s�b
	ACCOUNT_NOTFOUNT(404,"Account_Notfount"),//�䤣��b��
	BALANCE_IS_INSUFFICIENT(400,"Balance is insufficient"),//�l�B���� 
	;

	private int code;

	private String message;

	// source -->
	private RtnCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	// �u���Ψ�getter
	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
