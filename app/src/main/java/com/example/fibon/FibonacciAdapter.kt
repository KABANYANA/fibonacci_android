package com.example.fibon
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fibon.databinding.ItemFibonacciNumberBinding

class FibonacciAdapter(private val numbers: List<Long>) :
    RecyclerView.Adapter<FibonacciAdapter.FibonacciViewHolder>() {

    inner class FibonacciViewHolder(private val binding: ItemFibonacciNumberBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(number: Long) {
            binding.numberTextView.text = number.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FibonacciViewHolder {
        val binding = ItemFibonacciNumberBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return FibonacciViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FibonacciViewHolder, position: Int) {
        val number = numbers[position]
        holder.bind(number)
    }

    override fun getItemCount(): Int {
        return numbers.size
    }
}
