package com.ananda.app14_conheca_me

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(gerenciador: FragmentManager): FragmentPagerAdapter(gerenciador) {
    override fun getCount(): Int {
        return 4
    }

    override fun getItem(position: Int): Fragment {
        if (position == 0)
            return FragmentSobre()
        if (position == 1)
            return FragmentFormacao()
        if (position == 2)
            return FragmentExperiencia()
        else
            return FragmentDiferenciais()

    }

    override fun getPageTitle(position: Int): CharSequence? {
        if (position == 0)
            return "Sobre"
        if (position == 1)
            return "Formação"
        if (position == 1)
            return "Experiências"
        else
            return "Diferencial"
    }

}