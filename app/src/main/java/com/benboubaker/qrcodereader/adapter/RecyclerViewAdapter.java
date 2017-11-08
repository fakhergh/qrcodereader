package com.benboubaker.qrcodereader.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.benboubaker.qrcodereader.R;
import com.benboubaker.qrcodereader.models.Code;
import com.google.zxing.qrcode.encoder.QRCode;

import java.util.List;

/**
 * Created by fekhe on 06/11/2017.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Code> codes;

    public RecyclerViewAdapter(Context context, List<Code> codes) {
        this.context = context;
        this.codes = codes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Code code = codes.get(holder.getAdapterPosition());
        holder.txtContent.setText(code.getContent());
        holder.txtType.setText(code.getType());
    }

    @Override
    public int getItemCount() {
        return codes.size();
    }

    @Override
    public long getItemId(int position) {
        return codes.get(position).getId();
    }

    public void updateAndNotify(List<Code> codes) {
        this.codes = codes;
        notifyDataSetChanged();
    }

    public void remove(int pos) {
        codes.remove(pos);
        notifyItemRemoved(pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtContent;
        private TextView txtType;

        public ViewHolder(View itemView) {
            super(itemView);
            txtContent = (TextView) itemView.findViewById(R.id.textContent);
            txtType = (TextView) itemView.findViewById(R.id.textType);
        }
    }
}
