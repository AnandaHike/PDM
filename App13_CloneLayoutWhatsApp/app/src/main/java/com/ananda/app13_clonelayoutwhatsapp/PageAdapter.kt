package com.ananda.app13_clonelayoutwhatsapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(gerenciador: FragmentManager): FragmentPagerAdapter(gerenciador) {
    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
         if (position == 0)
             return FragmentConversas02()
        if (position == 1)
            return FragmentStatus03()
        else
            return FragmentChamadas04()

    }

    override fun getPageTitle(position: Int): CharSequence? {
        if (position == 0)
            return "Conversa"
        if (position == 1)
            return "Status"
        else
            return "Chamadas"
    }

}
