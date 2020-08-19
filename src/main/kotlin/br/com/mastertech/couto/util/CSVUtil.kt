package br.com.mastertech.couto.util

import java.io.FileNotFoundException
import java.io.FileWriter
import java.io.IOException
import java.io.PrintWriter

object CSVUtil {

    fun writeAccessCSV(customerId: Integer, doorId: Integer, hasAccess: Boolean) {
        try {
            val fileWriter = FileWriter("logCustomerAccess.csv", true)
            val printWriter = PrintWriter(fileWriter)
            val sb = StringBuilder()
            sb.append("Customer ID,")
            sb.append("Door ID,")
            sb.append("HAS ACCESS?")
            sb.append('\n')
            sb.append(customerId)
            sb.append(',')
            sb.append(doorId)
            sb.append(',')
            sb.append(hasAccess)
            sb.append('\n')
            printWriter.write(sb.toString())
            printWriter.close()
        } catch (e: FileNotFoundException) {
            println(e.message)
        } catch (e: IOException) {
            println(e.message)
        }
    }
}