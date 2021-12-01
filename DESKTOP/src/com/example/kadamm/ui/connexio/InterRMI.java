package com.example.kadamm.ui.connexio;

import kadamm.hibernate.model.Respostes;
import kadamm.hibernate.model.Torn;

public interface InterRMI{
	public void recieveResposta(Torn torn, Respostes resposta);
	public void setNickName(String nickname);
	public boolean getWaitingRoomStatus();
	public boolean isUserAvailable(String nickname);
}

//ConnRMILipe