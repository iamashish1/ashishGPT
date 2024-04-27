package com.example.ashishgpt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class Adapter(
    private var rooms:MutableList<ChatClass>,
): RecyclerView.Adapter<Adapter.RoomViewHolder>() {

    override fun getItemViewType(position: Int): Int {

//        return super.getItemViewType(position)


        if(rooms[position].isSender){
            return 0;
        }else{
            return 1;
        }
    }


    inner class RoomViewHolder(roomView: View): RecyclerView.ViewHolder(roomView){
        var tvTitle: TextView

        init {
            tvTitle = roomView.findViewById(R.id.textView)


            roomView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {

                    //NOTE: This click listener can also be set in onBindViewHolder
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomViewHolder {
        if(viewType==0){
            val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item,parent,false)
            return RoomViewHolder(view)
        }else{
            val view = LayoutInflater.from(parent.context).inflate(R.layout.gpt_item,parent,false)
            return RoomViewHolder(view)

        }

    }

    override fun getItemCount(): Int {
        return rooms.size
    }

    override fun onBindViewHolder(holder: RoomViewHolder, position: Int) {
//        holder.itemView.findViewById<TextView>(R.id.TitleId).text=rooms[position].title
//        holder.itemView.findViewById<TextView>(R.id.AddressId).text=rooms[position].address
        //OR
//        holder.itemView.apply {
//            findViewById<TextView>(R.id.TitleId).text=rooms[position].title
//            findViewById<TextView>(R.id.AddressId).text=rooms[position].address
//        }
        // OR
        // Load image into ImageView using Coil



        holder.tvTitle.text = rooms[position].question
//        holder.tvAddress.text = rooms[position].address
//        holder.tvRent.text = rooms[position].rent
//        holder.tvUtility.text = if (rooms[position].isUtilityIncluded) {
//            "Utility Included"
//        } else {
//            "Utility Not Included"
//        }
//
//        holder.tvFurnishing.text = rooms[position].furnishingType.toString()
//        holder.tvHouseType.text = rooms[position].houseType.toString()

    }

    fun updateRooms(newRooms: List<ChatClass>) {
        rooms.clear()
        rooms.addAll(newRooms)
        notifyDataSetChanged()
    }
}