//----------------------Adapter heart of recycler


package mine.com.ashishapp1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {


    private List<Listitem> listitems;
    Context context;

    public Adapter(List<Listitem> listitems, Context context) {
        this.listitems = listitems;
        this.context = context;

    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_list_layout, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {


        Listitem listitem = listitems.get(position);
        holder.name.setText(listitem.getName());
        holder.phone.setText(listitem.getPhone());
    }

    @Override
    public int getItemCount() {
        return listitems.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        ImageView imgicon;
        TextView name, phone;

        public Holder(View itemView) {
            super(itemView);
            imgicon = (ImageView) itemView.findViewById(R.id.imgicon);
            name = (TextView) itemView.findViewById(R.id.name_dis);
            phone = (TextView) itemView.findViewById(R.id.phone_dis);
        }
    }

}
