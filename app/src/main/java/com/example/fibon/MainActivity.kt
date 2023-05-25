package com.example.fibon


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fibon.databinding.ActivityMainBinding
import com.example.fibon.databinding.ItemFibonacciNumberBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: FibonacciAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = FibonacciAdapter(getFibonacciNumbers(100))
        binding.recyclerView.adapter = adapter
    }

    private fun getFibonacciNumbers(count: Int): List<Long> {
        val fibonacciNumbers = mutableListOf<Long>()

        var a = 0L
        var b = 1L

        for (i in 1..count) {
            fibonacciNumbers.add(a)

            val sum = a + b
            a = b
            b = sum
        }

        return fibonacciNumbers
    }

    inner class FibonacciAdapter(private val numbers: List<Long>) :
        RecyclerView.Adapter<FibonacciAdapter.FibonacciViewHolder>() {

        inner class FibonacciViewHolder(private val itemBinding: ItemFibonacciNumberBinding) :
            RecyclerView.ViewHolder(itemBinding.root) {

            fun bind(number: Long) {
                itemBinding.numberTextView.text = number.toString()
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FibonacciViewHolder {
            val inflater = LayoutInflater.from(parent.context)
            val itemBinding = ItemFibonacciNumberBinding.inflate(inflater, parent, false)
            return FibonacciViewHolder(itemBinding)
        }

        override fun onBindViewHolder(holder: FibonacciViewHolder, position: Int) {
            val number = numbers[position]
            holder.bind(number)
        }

        override fun getItemCount(): Int {
            return numbers.size
        }
    }
}
