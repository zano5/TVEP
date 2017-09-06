package tut.ac.za.tvep.Adapter;

import android.content.Context;
import android.content.Intent;
import android.icu.text.IDNA;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

import butterknife.ButterKnife;
import tut.ac.za.tvep.R;
import tut.ac.za.tvep.WebActivity;
import tut.ac.za.tvep.classes.AppConstants;
import tut.ac.za.tvep.classes.Info;

/**
 * Created by mlab on 2017/07/02.
 */

public class InfoAdapter  extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder> {

    private Context context;
    private List<Info> infoList;


    public InfoAdapter(Context context, List<Info> infoList)
    {
        this.context =context;
        this.infoList =infoList;
    }


    @Override
    public InfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tips_view,parent,false);

        InfoViewHolder ivh = new InfoViewHolder(view);


        return  ivh;
    }

    @Override
    public void onBindViewHolder(InfoViewHolder holder, int position) {


        final Info info = infoList.get(position);

        holder.tvInfo.setText(info.getName());

        holder.cdInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(context, WebActivity.class);
                intent.putExtra(AppConstants.INFO,info);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    public class InfoViewHolder extends RecyclerView.ViewHolder {

        private CardView cdInfo;
        private TextView tvInfo;
        public InfoViewHolder(View itemView) {
            super(itemView);

            cdInfo = ButterKnife.findById(itemView,R.id.cdTips);
            tvInfo = ButterKnife.findById(itemView, R.id.tvInfo);
        }
    }
}
