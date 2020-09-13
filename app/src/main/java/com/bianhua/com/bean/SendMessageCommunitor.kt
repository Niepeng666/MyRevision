package com.bianhua.com.bean

interface SendMessageCommunitor {
    /**从fragment发送消息
     * @param msg 消息内容
     */
    fun sendMessage(msg: String?)
}