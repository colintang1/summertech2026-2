using System.Diagnostics;
using TMPro;
using UnityEngine;
using UnityEngine.SceneManagement;
public class Manager : MonoBehaviour
{
    private int deathCounter = 0;
    [SerializeField] private TMP_Text timerText;
    private Stopwatch timer;
    [SerializeField] private TMP_Text deathText;
    public void Start()
    {
        timer = Stopwatch.StartNew();
    }
    public void PlayButton()
    {
        SceneManager.LoadScene(1);
    }
    public void addDeath()
    {
        deathCounter++;
        deathText.SetText("Deaths: "+deathCounter);
        timer = Stopwatch.StartNew();
    }
    public void Update()
    {
       timerText.SetText("Time: "+System.Math.Round(timer.Elapsed.TotalSeconds, 2));
    }
    public void StopTimer()
    {
        timer.Stop();
    }
}